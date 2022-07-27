<template>
  <a @click.stop="toggleMenu" class="btn menu-toggle-btn">
    <BaseIcon icon="list" :variant="null" fontScale="1.5" aria-hidden="true" />
  </a>
</template>

<script>
export default {
  methods: {
    toggleMenu() {
      window.bus.$emit('menu/toggle')
    }
  }
}
</script>

<style scoped>
@media (min-width: 768px) {
  .btn {
    display: none;
  }
}
</style>
