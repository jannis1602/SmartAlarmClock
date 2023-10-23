<script>
    import "../app.css";
    import { page } from "$app/stores";
</script>

<header class="p-4">
    <nav>
        <ul class="flex gap-4">
            <li>
                <a href="/">Home</a>
            </li>
            <li>
                <a href="/settings">Settings</a>
            </li>
        </ul>
    </nav>
    <h1 class="text-2xl">{$page.url.pathname}</h1>
</header>
<main class="p-4">
    <slot />
</main>