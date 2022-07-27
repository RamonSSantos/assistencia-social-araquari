<template>
  <div id="app">
    <template v-if="this.$route.name === 'Login' || this.$route.name === null">
      <NotificationContainer></NotificationContainer>
      <router-view />
    </template>
    <template
      v-else-if="this.$route.name !== 'Login' || this.$route.name !== null"
    >
      <div id="wrapper" :class="wrapperClass">
        <Menu></Menu>
        <MenuToggleButton></MenuToggleButton>
        <ContentOverlay></ContentOverlay>
        <div class="main-content">
          <NotificationContainer></NotificationContainer>
          <router-view />
        </div>
      </div>
    </template>
  </div>
</template>

<script>
import { mapState } from 'vuex'

export default {
  data() {
    return {
      isOpenMobileMenu: false
    }
  },
  computed: {
    ...mapState('auth', ['user']),
    routes() {
      return this.$router.options.routes.filter(route => route.meta)
    },
    wrapperClass() {
      return {
        toggled: this.isOpenMobileMenu === true
      }
    }
  },
  created() {
    window.bus.$on('menu/toggle', () => {
      window.setTimeout(() => {
        this.isOpenMobileMenu = !this.isOpenMobileMenu
      }, 200)
    })
    window.bus.$on('menu/closeMobileMenu', () => {
      this.isOpenMobileMenu = false
    })
  }
}
</script>

<style lang="scss">
@import url('https://fonts.googleapis.com/css2?family=Source+Sans+Pro:wght@300;400;700&display=swap');
@import '@/styles/layout.scss';
@import '@/styles/menu-toggle-btn.scss';
@import '@/styles/menu.scss';
@import '@/styles/content-overlay.scss';
@import '@/styles/media-queries.scss';

body {
  font-family: 'Source Sans Pro', sans-serif !important;
}
input::-webkit-calendar-picker-indicator,
input::-webkit-inner-spin-button {
  display: none;
}

input[type='date']::-webkit-input-placeholder {
  visibility: hidden !important;
}

.card-body {
  padding: 0.75rem !important;
}

.cursor-pointer {
  cursor: pointer;
}
</style>
