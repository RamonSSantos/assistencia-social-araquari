<template>
  <div class="notification-container">
    <NotificationBar
      v-for="notification in notifications"
      :key="notification.id"
      :notification="notification"
    />
  </div>
</template>

<script>
import { mapState } from 'vuex'

export default {
  computed: mapState('notification', ['notifications'])
}
</script>

<style scoped>
.notification-container {
  position: fixed;
  z-index: 1;
  bottom: 0;
  right: 0;
  padding-right: 1rem;
}
</style>
