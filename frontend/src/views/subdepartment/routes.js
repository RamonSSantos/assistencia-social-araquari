const name = 'Subdepartment'
const path = '/equipamentos'
const textSingular = 'Equipamento'
const textPlural = 'Equipamentos'

export default [
  {
    name: name,
    path: `${path}?page=:page`,
    component: () => import('./Subdepartment'),
    meta: {
      title: textPlural,
      breadCrumb: textPlural,
      eventBus: 'refresh-table-subdepartments'
    },
    children: [
      {
        name: `${name}New`,
        path: `${path}/novo`,
        component: () => import('./SubdepartmentNew'),
        meta: {
          title: `Novo ${textSingular}`,
          breadCrumb: 'Novo',
          eventBus: 'refresh-table-subdepartments'
        },
        props: true
      },
      {
        name: `${name}Edit`,
        path: `${path}/editar/:id`,
        component: () => import('./SubdepartmentEdit'),
        meta: {
          title: `Editar ${textSingular}`,
          breadCrumb: 'Editar',
          eventBus: 'refresh-table-subdepartments'
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
