const name = 'User'
const path = '/usuarios'
const textSingular = 'Usuário'
const textPlural = 'Usuários'

export default [
  {
    name: name,
    path: `${path}?page=:page`,
    component: () => import('./User'),
    meta: {
      title: textPlural,
      breadCrumb: textPlural,
      eventBus: 'refresh-table-users'
    },
    children: [
      {
        name: `${name}New`,
        path: `${path}/novo`,
        component: () => import('./UserNew'),
        meta: {
          title: `Novo ${textSingular}`,
          breadCrumb: 'Novo',
          eventBus: 'refresh-table-users'
        },
        props: true
      },
      {
        name: `${name}View`,
        path: `${path}/visualizar/:id`,
        component: () => import('./UserView'),
        meta: {
          title: `Visualizar ${textSingular}`,
          breadCrumb: 'Visualizar',
          eventBus: 'refresh-table-users'
        },
        props: true
      },
      {
        name: `${name}Edit`,
        path: `${path}/editar/:id`,
        component: () => import('./UserEdit'),
        meta: {
          title: `Editar ${textSingular}`,
          breadCrumb: 'Editar',
          eventBus: 'refresh-table-users'
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
