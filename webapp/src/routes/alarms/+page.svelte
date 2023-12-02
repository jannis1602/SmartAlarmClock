<script lang="ts">
	let showNewAlarmModal = false;
	let showAlarmSettingsModal = false;
	let alarmIsActive = false;
</script>

<div class="p-4 flex flex-col gap-4">
	<h1 class="text-3xl">Alarms</h1>
	<button
		class="bg-neutral-800 border border-neutral-700 ps-4 pe-4 py-2 rounded mt-2 self-start"
		on:click={() => (showNewAlarmModal = true)}>New alarm</button
	>
	<h2 class="text-2xl">Your alarms</h2>
	<ul>
		<li
			class="flex gap-4 flex-wrap justify-between ps-4 pe-4 py-2 border border-neutral-800 rounded"
		>
			<div>
				<p>Time: <strong>07:00 AM</strong></p>
				<ul class="flex gap-2 flex-wrap">
					<li>Monday</li>
				</ul>
			</div>
			<div class="flex gap-2 items-center">
				<form action="">
					<button
						class="bg-red-900 border border-neutral-700 ps-4 pe-4 py-2 rounded mt-2 flex gap-2 items-center"
						on:click={() => (alarmIsActive = !alarmIsActive)}
						class:bg-green-900={alarmIsActive}
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
							{alarmIsActive ? 'On' : 'Off'}
						</span>
					</button>
				</form>
				<form action="">
					<button
						class="bg-neutral-800 border border-neutral-700 ps-4 pe-4 py-2 rounded mt-2 flex gap-2 items-center"
						on:click={() => (showAlarmSettingsModal = true)}
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
				</form>
			</div>
		</li>
	</ul>
</div>

{#if showNewAlarmModal}
	<div
		class="flex flex-col gap-4 p-4 rounded bg-neutral-800 border border-neutral-700 fixed start-1/2 top-1/2 -translate-x-1/2 -translate-y-1/2"
	>
		<h2 class="text-xl">Create new alarm</h2>
		<form class="flex flex-col gap-4 items-start">
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
				/>
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

{#if showAlarmSettingsModal}
	<div
		class="flex flex-col gap-4 p-4 rounded bg-neutral-800 border border-neutral-700 fixed start-1/2 top-1/2 -translate-x-1/2 -translate-y-1/2"
	>
		<h2 class="text-xl">Edit alarm</h2>
		<form class="flex flex-col gap-4 items-start">
			<div class="flex flex-col gap-1">
				<label for="new-alarm-date">Date:</label>
				<input
					type="date"
					id="new-alarm-date"
					name="new-alarm-date"
					class="ps-4 pe-4 py-2 rounded"
					value="2023-12-04"
				/>
			</div>
			<div class="flex flex-col gap-1">
				<label for="new-alarm-time">Time:</label>
				<input
					id="new-alarm-time"
					type="time"
					name="new-alarm-time"
					class="ps-4 pe-4 py-2 rounded"
					value="07:00"
				/>
			</div>
			<div class="flex gap-4">
				<button
					type="submit"
					class="bg-neutral-700 border border-neutral-600 ps-4 pe-4 py-2 rounded mt-2"
					>Update</button
				>
				<button
					class="bg-neutral-700 border border-neutral-600 ps-4 pe-4 py-2 rounded mt-2"
					on:click={() => (showAlarmSettingsModal = false)}>Cancel</button
				>
			</div>
		</form>
	</div>
{/if}
