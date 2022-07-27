const name = 'FamilyReference'
const path = '/referencias-familiares'
const textSingular = 'Referência Familiar'
const textPlural = 'Referências Familiares'

export default [
  {
    name: name,
    path: `${path}?page=:page`,
    component: () => import('./FamilyReference'),
    meta: {
      title: textPlural,
      breadCrumb: textPlural,
      eventBus: 'refresh-table-familyReferences'
    },
    children: [
      {
        name: `${name}View`,
        path: `${path}/visualizar/:id`,
        component: () => import('./FamilyReferenceView'),
        meta: {
          title: `Visualizar ${textSingular}`,
          breadCrumb: 'Visualizar',
          eventBus: 'refresh-table-familyReferences'
        },
        props: true
      },
      {
        name: `${name}Edit`,
        path: `${path}/editar/:id`,
        component: () => import('./FamilyReferenceEdit'),
        meta: {
          title: `Editar ${textSingular}`,
          breadCrumb: 'Editar',
          eventBus: 'refresh-table-familyReferences'
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
