const name = 'Monitoring'
const path = '/acompanhamentos'
const textSingular = 'Acompanhamento'
const textPlural = 'Acompanhamentos'

export default [
  {
    name: name,
    path: `${path}?page=:page`,
    component: () => import('./Monitoring'),
    meta: {
      title: textPlural,
      breadCrumb: textPlural,
      eventBus: 'refresh-table-monitoring'
    },
    children: [
      {
        name: `${name}New`,
        path: `${path}/novo`,
        component: () => import('./MonitoringNew'),
        meta: {
          title: `Novo ${textSingular}`,
          breadCrumb: 'Novo',
          eventBus: 'refresh-table-monitoring'
        },
        props: true
      },
      {
        name: `${name}View`,
        path: `${path}/visualizar/:id`,
        component: () => import('./MonitoringView'),
        meta: {
          title: `Visualizar ${textSingular}`,
          breadCrumb: 'Visualizar',
          eventBus: 'refresh-table-monitoring'
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
