<script lang="ts">
    import { onMount } from "svelte";

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

<p class="text-3xl">{`${pad(hours)}:${pad(minutes)}:${pad(seconds)}`}</p>