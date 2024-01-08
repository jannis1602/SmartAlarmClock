<script lang="ts">
	import '../app.css';
</script>

<header class="p-4 h-12 bg-neutral-800 grid place-content-center border-b border-neutral-700">
	<nav>
		<ul class="flex gap-4">
			<li>
				<a href="/">Home</a>
			</li>
			<li>
				<a href="/alarms">Alarms</a>
			</li>
			<li>
				<a href="/statistics">Statistics</a>
			</li>
			<li>
				<a href="/settings">Settings</a>
			</li>
		</ul>
	</nav>
</header>
<main>
	<slot />
</main>
