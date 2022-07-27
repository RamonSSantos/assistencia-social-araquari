<template>
  <div class="text-uppercase style-breadcrumb my-1">
    <b-breadcrumb class="pr-0">
      <b-breadcrumb-item :to="{ name: 'Home' }">
        <BaseIcon
          icon="house-door-fill"
          scale="1.05"
          shiftV="1.05"
          aria-hidden="true"
          class="mr-1"
        />Home
      </b-breadcrumb-item>
      <span class="px-2">/</span>
    </b-breadcrumb>
    <b-breadcrumb
      :items="crumbs"
      @click.stop="goToParentPage"
      class="pl-0"
    ></b-breadcrumb>
  </div>
</template>

<script>
import EventBus from '@/services/EventBus'

export default {
  computed: {
    crumbs() {
      let pathArray = this.$route.path.split('/')
      pathArray.shift()
      if (pathArray.length === 3) pathArray.pop()

      let breadcrumbs = pathArray.reduce((breadcrumbArray, path, idx) => {
        breadcrumbArray.push({
          path: path,
          to: breadcrumbArray[idx - 1]
            ? `/${breadcrumbArray[idx - 1].path}/${path}`
            : {
                name: this.$route.matched[idx].name,
                params: { page: 1 }
              },
          text: this.$route.matched[idx].meta.breadCrumb || path
        })
        return breadcrumbArray
      }, [])
      return breadcrumbs
    }
  },
  methods: {
    goToParentPage() {
      EventBus.$emit(this.$route.meta.eventBus)
    }
  }
}
</script>

<style scoped>
.breadcrumb {
  display: inline-flex;
  border-radius: inherit;
  margin-bottom: 0;
}

.style-breadcrumb {
  background-color: #e9ecef;
  border-radius: 0.25rem;
}

.breadcrumb-item + .breadcrumb-item::before {
  color: #000000;
}
</style>
