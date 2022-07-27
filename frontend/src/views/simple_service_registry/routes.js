const name = 'SimpleServiceRegistry'
const path = '/registro-simplificado-dos-atendimentos'
const textSingular = 'Registro Simplificado do Atendimento'
const textPlural = 'Registro Simplificado dos Atendimentos'

export default [
  {
    name: name,
    path: `${path}?page=:page`,
    component: () => import('./SimpleServiceRegistry'),
    meta: {
      title: textPlural,
      breadCrumb: textPlural,
      eventBus: 'refresh-list-single-registry-identification'
    },
    children: [
      {
        name: `${name}New`,
        path: `${path}/novo`,
        component: () => import('./SimpleServiceRegistryNew'),
        meta: {
          title: `Novo ${textSingular}`,
          breadCrumb: 'Novo',
          eventBus: 'refresh-list-single-registry-identification'
        },
        props: true
      },
      {
        name: `${name}View`,
        path: `${path}/visualizar/:id`,
        component: () => import('./SimpleServiceRegistryView'),
        meta: {
          title: `Visualizar ${textSingular}`,
          breadCrumb: 'Visualizar',
          eventBus: 'refresh-list-single-registry-identification'
        },
        props: true
      }
    ]
  },
  {
    path,
    redirect: to => to.fullPath
  }
]
