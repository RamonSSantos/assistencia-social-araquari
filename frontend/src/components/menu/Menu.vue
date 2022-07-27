<template>
  <div class="menu-container">
    <ul class="menu">
      <li class="menu__top mx-auto">
        <router-link
          :to="{ name: 'Home' }"
          @click.stop="updateMenu('home')"
          class="menu__title mx-auto"
        >
          Assistência Social - Araquari
        </router-link>
      </li>
      <li>
        <b-link
          :to="{ name: 'User', params: { page: 1 } }"
          @click.stop="updateMenu('users')"
          :class="highlightSection('users')"
        >
          <BaseIcon
            icon="people-fill"
            :variant="null"
            fontScale="1.5"
            aria-hidden="true"
            class="mr-1"
          />
          Usuários
        </b-link>
      </li>
      <li>
        <b-link
          :to="{ name: 'Subdepartment', params: { page: 1 } }"
          @click.stop="updateMenu('subdepartments')"
          :class="highlightSection('subdepartments')"
        >
          <BaseIcon
            icon="grid-fill"
            :variant="null"
            fontScale="1.5"
            aria-hidden="true"
            class="mr-1"
          />
          Equipamentos
        </b-link>
      </li>
      <li>
        <b-link
          :to="{ name: 'FamilyReference', params: { page: 1 } }"
          @click.stop="updateMenu('familyReferences')"
          :class="highlightSection('familyReferences')"
        >
          <BaseIcon
            icon="person-lines-fill"
            :variant="null"
            fontScale="1.5"
            aria-hidden="true"
            class="mr-1"
          />
          Famílias
        </b-link>
      </li>
      <li>
        <b-link
          :to="{ name: 'SimpleServiceRegistry', params: { page: 1 } }"
          @click.stop="updateMenu('simpleServiceRegistry')"
          :class="highlightSection('simpleServiceRegistry')"
        >
          <BaseIcon
            icon="file-text"
            :variant="null"
            fontScale="1.5"
            aria-hidden="true"
            class="mr-1"
          />
          Atendimentos
        </b-link>
      </li>
      <li>
        <b-link
          :to="{ name: 'Monitoring', params: { page: 1 } }"
          @click.stop="updateMenu('monitoring')"
          :class="highlightSection('monitoring')"
        >
          <BaseIcon
            icon="file-text"
            :variant="null"
            fontScale="1.5"
            aria-hidden="true"
            class="mr-1"
          />
          Acompanhamentos
        </b-link>
      </li>
      <li>
        <b-link
          :to="{ name: 'DispatchControl', params: { page: 1 } }"
          @click.stop="updateMenu('dispatchControl')"
          :class="highlightSection('dispatchControl')"
        >
          <BaseIcon
            icon="reply-all-fill"
            :variant="null"
            fontScale="1.5"
            aria-hidden="true"
            class="mr-1"
          />
          Encaminhamentos
        </b-link>
      </li>
      <div class="bottom-position text-white">
        <li class="px-3">
          <b-row>
            <b-col cols="1" class="avatar-style pr-0">
              <b-avatar variant="info" :text="avatarText" size="3em"></b-avatar>
            </b-col>
            <b-col class="font-weight-bold">
              <span> {{ userInformation.fullname }} </span>
              <span> {{ userInformation.profile.description }} </span>
            </b-col>
          </b-row>
        </li>
        <li class="mt-2">
          <b-link
            @click.stop="modalLogout = !modalLogout"
            :class="highlightSection('exit')"
          >
            <BaseIcon
              icon="power"
              :variant="null"
              fontScale="1.5"
              aria-hidden="true"
              class="mr-1"
            />
            Sair
          </b-link>
        </li>
      </div>
    </ul>
    <b-modal
      v-model="modalLogout"
      :title="titleModalLogout"
      @ok.prevent="logoff"
      centered
      ok-title="Sim"
      cancel-title="Não"
      body-class="modal-body-logout"
    >
    </b-modal>
    <transition name="slide-fade">
      <div class="context-menu-container" v-show="showContextMenu">
        <ul class="context-menu">
          <li v-for="(item, index) in menuItens" :key="index">
            <h5 v-if="item.type === 'title'" class="context-menu__title">
              <i :class="item.icon" aria-hidden="true"></i>
              {{ item.txt }}
              <a
                v-if="index === 0"
                @click.stop="closeContextMenu"
                class="context-menu__btn-close"
                href="#"
              >
                <BaseIcon
                  icon="x-circle"
                  :variant="null"
                  fontScale="1.5"
                  aria-hidden="true"
                />
              </a>
            </h5>
            <a
              v-else
              href="#"
              @click.stop="openSection(item)"
              :class="subMenuClass(item.txt)"
            >
              {{ item.txt }}
            </a>
          </li>
        </ul>
      </div>
    </transition>
  </div>
</template>

<script>
import { mapActions } from 'vuex'
import menuData from './support/menu-data'
import kebabCase from 'lodash/kebabCase'

export default {
  name: 'Menu',
  data() {
    return {
      contextSection: '',
      menuItens: [],
      menuData: menuData,
      activeSubMenu: '',
      userInformation: {
        fullname: '',
        profile: {
          description: ''
        }
      },
      avatarText: '',
      modalLogout: false,
      titleModalLogout: ''
    }
  },
  computed: {
    showContextMenu() {
      return this.menuItens.length
    }
  },
  async created() {
    if (this.$store.getters['auth/hasToken']) {
      await this.showUserInformation()
      this.setAvatarText()
      this.titleModalLogout = `${this.userInformation.fullname}, tem certeza que deseja sair?`
    }
  },
  methods: {
    ...mapActions('auth', ['ActionGetUser']),
    async showUserInformation() {
      const response = await this.ActionGetUser()
      this.userInformation.fullname = response[1]
      this.userInformation.profile.description = response[4].description
    },
    setAvatarText() {
      let fullname = this.userInformation.fullname.split(' ')
      const sizeName = fullname.length

      let firstName = fullname[0].charAt(0)
      let lastName = fullname[sizeName - 1].charAt(0)

      this.avatarText = firstName + lastName
    },
    updateMenu(context) {
      this.contextSection = context
      this.menuItens = this.menuData[context]
      if (context === 'home') {
        this.$router.push('/')
        window.bus.$emit('menu/closeMobileMenu')
      }
    },
    highlightSection(section) {
      return {
        menu__link: true,
        'menu__link--active': section === this.contextSection
      }
    },
    subMenuClass(subMenuName) {
      return {
        'context-menu__link': true,
        'context-menu__link--active': this.activeSubMenu === subMenuName
      }
    },
    closeContextMenu() {
      this.contextSection = ''
      this.menuItens = []
    },
    openSection(item) {
      this.activeSubMenu = item.txt
      this.$router.push(this.getUrl(item))
      window.bus.$emit('menu/closeMobileMenu')
    },
    getUrl(item) {
      let sectionSlug = kebabCase(item.txt)
      return `${item.link}/${sectionSlug}`
    },
    ...mapActions('auth', ['ActionSignOut']),
    async logoff() {
      await this.ActionSignOut()
      setTimeout(() => this.$router.push({ name: 'Login' }), 1000)
    }
  }
}
</script>

<style scoped>
.bottom-position {
  position: absolute;
  bottom: 0;
}

.avatar-style {
  max-width: max-content;
  transition: transform 0.2s;
}

.avatar-style:hover {
  transform: scale(1.1);
}
</style>
