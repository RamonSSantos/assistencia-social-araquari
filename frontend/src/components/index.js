import Vue from 'vue'
import upperFirst from 'lodash/upperFirst'
import camelCase from 'lodash/camelCase'

export default () => {
  const requireComponent = require.context('./', true, /[A-Z]\w+\.(vue|js)$/)

  requireComponent.keys().forEach(fileName => {
    const componentConfig = requireComponent(fileName)

    const componentName = upperFirst(
      camelCase(
        fileName
          .split('/')
          .pop()
          .replace(/\.\w+$/, '')
      )
    )
    Vue.component(componentName, componentConfig.default || componentConfig)
  })
  Vue.config.productionTip = false
}
