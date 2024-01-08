import type { Actions, PageServerLoad } from './$types';

export const load: PageServerLoad = async ({ fetch }) => {
	const res = await fetch(`http://192.168.178.126:8080/api/v1/wecker/areas/`);
	const test = res.json();

	return { test };
};

export const actions: Actions = {
	createAlarm: async ({ request, fetch }) => {
		try {
			const data = await request.formData();

			const alarmDate = data.get('new-alarm-date');
			const alarmTime = data.get('new-alarm-time');

			const response = await fetch(`http://192.168.178.126:8080/api/v1/wecker/configurations/`, {
				method: 'POST',
				headers: {
					'Content-Type': 'application/json',
					'Accept': 'application/json'
				},
				body: JSON.stringify({
					id: 123,
					timestamp: 123,
					maxDuration: 123,
					active: true,
					days: [
						{
							id: 123,
							name: 'Donnerstag',
							active: true
						},
					],
				})
			});

			const responseData = await response.text();
			console.log(responseData);
		} catch (error) {
			console.error(error);
		}
	},
	updateAlarmActiveStatus: async ({ request, fetch }) => {},
	deleteAlarm: async ({ request }) => {},
	updateAlarm: async ({ request }) => {
		const data = await request.formData();

		const alarmDate = data.get('new-alarm-date');
		const alarmTime = data.get('new-alarm-time');
	}
};
