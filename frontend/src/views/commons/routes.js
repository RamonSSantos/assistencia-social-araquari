export default [
  {
    name: 'NotFound',
    path: '/404',
    component: () => import('./NotFound'),
    meta: {
      title: 'Página inexistente'
    }
  },
  {
    name: 'NetworkIssue',
    path: '/network-issue',
    component: () => import('./NetworkIssue'),
    meta: {
      title: 'Site fora do ar'
    }
  },
  {
    path: '*',
    redirect: { name: 'NotFound' }
  }
]
