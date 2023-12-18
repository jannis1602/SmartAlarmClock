<script lang="ts">
	import { enhance } from '$app/forms';
	import type { PageData } from '../$types';

	let showNewAlarmModal = false;
	let editingAlarmId = null;

	export let data: PageData;

	const allDays = ['Montag', 'Dienstag', 'Mittwoch', 'Donnerstag', 'Freitag', 'Samstag', 'Sonntag'];
</script>

<div class="p-4 flex flex-col gap-4">
	<h1 class="text-3xl">Alarms</h1>
	<button
		class="bg-neutral-800 border border-neutral-700 ps-4 pe-4 py-2 rounded mt-2 self-start"
		on:click={() => (showNewAlarmModal = true)}>New alarm</button
	>
	<h2 class="text-2xl">Your alarms</h2>
	{JSON.stringify(data.alarms)}
	<ul class="flex flex-col gap-4">
		{#each data.alarms as alarm}
			<li
				class="flex gap-4 flex-wrap justify-between ps-4 pe-4 py-2 border border-neutral-800 rounded"
			>
				<div>
					<p>Time: <strong>{alarm.alarmTime}</strong></p>
					{#if alarm.days.length !== 0}
						<ul class="flex gap-2 flex-wrap">
							{#each alarm.days as day}
								<li>{day.name}</li>
							{/each}
						</ul>
					{/if}
				</div>
				<div class="flex gap-2 items-center">
					<form action="?/updateAlarmActiveStatus" method="post" use:enhance>
						<input type="hidden" name="alarmId" value={alarm.id} />
						<input type="hidden" name="alarmIsActive" value={alarm.active} />
						<button
							class="border border-neutral-700 ps-4 pe-4 py-2 rounded mt-2 flex gap-2 items-center"
							type="submit"
						>
							<svg
								xmlns="http://www.w3.org/2000/svg"
								viewBox="0 0 20 20"
								fill="currentColor"
								class="w-5 h-5"
							>
								<path
									fill-rule="evenodd"
									d="M10 2a.75.75 0 01.75.75v7.5a.75.75 0 01-1.5 0v-7.5A.75.75 0 0110 2zM5.404 4.343a.75.75 0 010 1.06 6.5 6.5 0 109.192 0 .75.75 0 111.06-1.06 8 8 0 11-11.313 0 .75.75 0 011.06 0z"
									clip-rule="evenodd"
								/>
							</svg>
							<span>
								{alarm.active ? 'On' : 'Off'}
							</span>
						</button>
					</form>
					<form action="?/deleteAlarm" method="post" use:enhance>
						<input type="hidden" name="alarmId" value={alarm.id} />
						<button
							class="bg-neutral-800 border border-neutral-700 ps-4 pe-4 py-2 rounded mt-2 flex gap-2 items-center"
						>
							<svg
								xmlns="http://www.w3.org/2000/svg"
								viewBox="0 0 20 20"
								fill="currentColor"
								class="w-5 h-5"
							>
								<path
									fill-rule="evenodd"
									d="M8.75 1A2.75 2.75 0 006 3.75v.443c-.795.077-1.584.176-2.365.298a.75.75 0 10.23 1.482l.149-.022.841 10.518A2.75 2.75 0 007.596 19h4.807a2.75 2.75 0 002.742-2.53l.841-10.52.149.023a.75.75 0 00.23-1.482A41.03 41.03 0 0014 4.193V3.75A2.75 2.75 0 0011.25 1h-2.5zM10 4c.84 0 1.673.025 2.5.075V3.75c0-.69-.56-1.25-1.25-1.25h-2.5c-.69 0-1.25.56-1.25 1.25v.325C8.327 4.025 9.16 4 10 4zM8.58 7.72a.75.75 0 00-1.5.06l.3 7.5a.75.75 0 101.5-.06l-.3-7.5zm4.34.06a.75.75 0 10-1.5-.06l-.3 7.5a.75.75 0 101.5.06l.3-7.5z"
									clip-rule="evenodd"
								/>
							</svg>
						</button>
					</form>
					<button
						class="bg-neutral-800 border border-neutral-700 ps-4 pe-4 py-2 rounded mt-2 flex gap-2 items-center"
						on:click={() => (editingAlarmId = alarm.id)}
					>
						<svg
							xmlns="http://www.w3.org/2000/svg"
							viewBox="0 0 20 20"
							fill="currentColor"
							class="w-5 h-5"
						>
							<path
								fill-rule="evenodd"
								d="M7.84 1.804A1 1 0 018.82 1h2.36a1 1 0 01.98.804l.331 1.652a6.993 6.993 0 011.929 1.115l1.598-.54a1 1 0 011.186.447l1.18 2.044a1 1 0 01-.205 1.251l-1.267 1.113a7.047 7.047 0 010 2.228l1.267 1.113a1 1 0 01.206 1.25l-1.18 2.045a1 1 0 01-1.187.447l-1.598-.54a6.993 6.993 0 01-1.929 1.115l-.33 1.652a1 1 0 01-.98.804H8.82a1 1 0 01-.98-.804l-.331-1.652a6.993 6.993 0 01-1.929-1.115l-1.598.54a1 1 0 01-1.186-.447l-1.18-2.044a1 1 0 01.205-1.251l1.267-1.114a7.05 7.05 0 010-2.227L1.821 7.773a1 1 0 01-.206-1.25l1.18-2.045a1 1 0 011.187-.447l1.598.54A6.993 6.993 0 017.51 3.456l.33-1.652zM10 13a3 3 0 100-6 3 3 0 000 6z"
								clip-rule="evenodd"
							/>
						</svg>
					</button>
				</div>
			</li>
			{#if editingAlarmId === alarm.id}
				<div
					class="flex flex-col gap-4 p-4 rounded bg-neutral-800 border border-neutral-700 fixed start-1/2 top-1/2 -translate-x-1/2 -translate-y-1/2 overflow-y-auto max-h-screen"
				>
					<h2 class="text-xl">Edit alarm</h2>
					<form class="flex flex-col gap-4" method="post" action="?/updateAlarm" use:enhance>
						<input type="hidden" name="alarmId" value={alarm.id} />
						<div class="flex flex-col gap-1">
							<label for="edit-alarm-{alarm.id}-date">Date:</label>
							<input
								type="date"
								id="edit-alarm-{alarm.id}-date"
								name="edit-alarm-{alarm.id}-date"
								class="ps-4 pe-4 py-2 rounded"
								value={alarm.alarmDate}
							/>
						</div>
						<div class="flex flex-col gap-1">
							<label for="edit-alarm-{alarm.id}-time">Time:</label>
							<input
								id="edit-alarm-{alarm.id}-time"
								type="time"
								name="edit-alarm-{alarm.id}-time"
								class="ps-4 pe-4 py-2 rounded"
								value={alarm.alarmTime}
								required
							/>
						</div>
						<div class="flex flex-col gap-1">
							<label for="edit-alarm-{alarm.id}-multiple-days"> Multiple days </label>
							<select
								id="edit-alarm-{alarm.id}-multiple-days"
								name="edit-alarm-{alarm.id}-multiple-days"
								multiple
							>
								{#each allDays as dayName}
									<option
										value={dayName}
										selected={alarm.days.map((day) => day.name).includes(dayName)}>{dayName}</option
									>
								{/each}
							</select>
						</div>
						<div class="flex gap-4">
							<button
								type="submit"
								class="bg-neutral-700 border border-neutral-600 ps-4 pe-4 py-2 rounded mt-2"
								>Update</button
							>
							<button
								class="bg-neutral-700 border border-neutral-600 ps-4 pe-4 py-2 rounded mt-2"
								on:click={() => (editingAlarmId = null)}>Cancel</button
							>
						</div>
					</form>
				</div>
			{/if}
		{/each}
	</ul>
</div>

{#if showNewAlarmModal}
	<div
		class="flex flex-col gap-4 p-4 rounded bg-neutral-800 border border-neutral-700 fixed start-1/2 top-1/2 -translate-x-1/2 -translate-y-1/2 overflow-y-auto max-h-screen"
	>
		<h2 class="text-xl">Create new alarm</h2>
		<form class="flex flex-col gap-4" method="post" action="?/createAlarm" use:enhance>
			<div class="flex flex-col gap-1">
				<label for="new-alarm-date">Date:</label>
				<input
					type="date"
					id="new-alarm-date"
					name="new-alarm-date"
					class="ps-4 pe-4 py-2 rounded"
				/>
			</div>
			<div class="flex flex-col gap-1">
				<label for="new-alarm-time">Time:</label>
				<input
					id="new-alarm-time"
					type="time"
					name="new-alarm-time"
					class="ps-4 pe-4 py-2 rounded"
					required
				/>
			</div>
			<div class="flex flex-col gap-1">
				<label for="new-alarm-multiple-days"> Multiple days </label>
				<select id="new-alarm-multiple-days" name="new-alarm-multiple-days" multiple>
					{#each allDays as dayName}
						<option value={dayName}>{dayName}</option>
					{/each}
				</select>
			</div>
			<div class="flex gap-4">
				<button
					type="submit"
					class="bg-neutral-700 border border-neutral-600 ps-4 pe-4 py-2 rounded mt-2"
					>Create alarm</button
				>
				<button
					class="bg-neutral-700 border border-neutral-600 ps-4 pe-4 py-2 rounded mt-2"
					on:click={() => (showNewAlarmModal = false)}>Cancel</button
				>
			</div>
		</form>
	</div>
{/if}
