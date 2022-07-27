const name = 'DispatchControl'
const path = '/encaminhamentos'
const textSingular = 'Encaminhamento'
const textPlural = 'Encaminhamentos'

export default [
  {
    name: name,
    path: `${path}?page=:page`,
    component: () => import('./DispatchControl'),
    meta: {
      title: textPlural,
      breadCrumb: textPlural,
      eventBus: 'refresh-table-dispatch-control'
    },
    children: [
      {
        name: `${name}New`,
        path: `${path}/novo`,
        component: () => import('./DispatchControlNew'),
        meta: {
          title: `Novo ${textSingular}`,
          breadCrumb: 'Novo',
          eventBus: 'refresh-table-dispatch-control'
        },
        props: true
      },
      {
        name: `${name}View`,
        path: `${path}/visualizar/:id`,
        component: () => import('./DispatchControlView'),
        meta: {
          title: `Visualizar ${textSingular}`,
          breadCrumb: 'Visualizar',
          eventBus: 'refresh-table-dispatch-control'
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
