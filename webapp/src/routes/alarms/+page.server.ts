import type { Actions, PageServerLoad } from './$types';

export const load: PageServerLoad = async ({ fetch }) => {
	const res = await fetch(`localhost:8080/api/v1/wecker/configurations/`);
	const alarms = res.json();

	return { alarms };
};

export const actions: Actions = {
	createAlarm: async ({ request, fetch }) => {
		try {
			const data = await request.formData();

			const alarmDate = data.get('new-alarm-date');
			const alarmTime = data.get('new-alarm-time');
			const alarmMultipleDays = data.getAll('new-alarm-multiple-days');

			const allDays = [
				'Montag',
				'Dienstag',
				'Mittwoch',
				'Donnerstag',
				'Freitag',
				'Samstag',
				'Sonntag'
			];

			const response = await fetch(`localhost:8080/api/v1/wecker/configurations/`, {
				method: 'POST',
				headers: {
					'Content-Type': 'application/json',
					Accept: 'application/json'
				},
				body: JSON.stringify({
					alarmDate,
					alarmTime,
					active: false,
					days: alarmMultipleDays.map((day) => ({
						id: allDays.indexOf(day as string) + 1,
						name: day,
						active: true
					}))
				})
			});

			const responseData = await response.text();
			console.log(responseData);
		} catch (error) {
			console.error(error);
		}
	},
	updateAlarmActiveStatus: async ({ request, fetch }) => {
		try {
			const data = await request.formData();

			const alarmId = data.get('alarmId');
			const alarmIsActive = data.get('alarmIsActive') === 'true';

			const response = await fetch(
				`localhost:8080/api/v1/wecker/configurations/${alarmId}`,
				{
					method: 'PUT',
					headers: {
						'Content-Type': 'application/json',
						Accept: 'application/json'
					},
					body: JSON.stringify({
						active: !alarmIsActive
					})
				}
			);

			const responseData = await response.text();
			console.log(responseData);
		} catch (error) {
			console.error(error);
		}
	},
	deleteAlarm: async ({ request }) => {
		const data = await request.formData();

		const alarmId = data.get('alarmId');

		await fetch(`localhost:8080/api/v1/wecker/configurations/${alarmId}`, {
			method: 'DELETE',
			headers: {
				'Content-Type': 'application/json',
				Accept: 'application/json'
			}
		});
	},
	updateAlarm: async ({ request }) => {
		try {
			const data = await request.formData();

			const alarmId = data.get('alarmId');
			const alarmDate = data.get(`edit-alarm-${alarmId}-date`) || '';
			const alarmTime = data.get(`edit-alarm-${alarmId}-time`);
			const alarmMultipleDays = data.getAll(`edit-alarm-${alarmId}-multiple-days`) || [];

			console.log(alarmId, alarmDate, alarmTime, alarmMultipleDays);

			const allDays = [
				'Montag',
				'Dienstag',
				'Mittwoch',
				'Donnerstag',
				'Freitag',
				'Samstag',
				'Sonntag'
			];

			const response = await fetch(
				`localhost:8080/api/v1/wecker/configurations/${alarmId}`,
				{
					method: 'PUT',
					headers: {
						'Content-Type': 'application/json',
						Accept: 'application/json'
					},
					body: JSON.stringify({
						alarmDate,
						alarmTime,
						days: alarmMultipleDays.map((day) => ({
							id: allDays.indexOf(day as string) + 1,
							name: day,
							active: true
						}))
					})
				}
			);

			const responseData = await response.text();
			console.log(responseData);
		} catch (error) {
			console.error(error);
		}
	}
};
