<script lang="ts">
	import { onMount } from 'svelte';

	let currentDate = new Date();

	$: hours = currentDate.getHours();
	$: minutes = currentDate.getMinutes();
	$: seconds = currentDate.getSeconds();

	onMount(() => {
		const interval = setInterval(() => {
			currentDate = new Date();
		}, 1000);

		return () => {
			clearInterval(interval);
		};
	});

	function pad(number: number): string {
		return number < 10 ? '0' + number : number.toString();
	}
</script>

<div class="grid place-content-center min-h-[calc(theme(height.screen)-theme(height.12))]">
	<h1 class="text-5xl">{`${pad(hours)}:${pad(minutes)}:${pad(seconds)}`}</h1>
</div>
