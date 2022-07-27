<template>
  <div class="notification-bar">
    <b-alert
      :variant="notificationTypeClass"
      class="pre-formatted"
      show
      dismissible
      >{{ notification.message }}</b-alert
    >
  </div>
</template>

<script>
import { mapActions } from 'vuex'

export default {
  props: {
    notification: {
      type: Object,
      required: true
    }
  },
  data() {
    return {
      timeout: null
    }
  },
  mounted() {
    this.timeout = setTimeout(() => this.remove(this.notification), 3000)
  },
  beforeDestroy() {
    clearTimeout(this.timeout)
  },
  computed: {
    notificationTypeClass() {
      return this.notification.type
    }
  },
  methods: mapActions('notification', ['remove'])
}
</script>

<style scoped>
.notification-bar {
  margin: 1rem 0 1rem;
}

.pre-formatted {
  white-space: pre;
}
</style>
