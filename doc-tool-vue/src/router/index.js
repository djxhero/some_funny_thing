import Vue from 'vue'
import Router from 'vue-router'
/* Layout */
// import Layout from '@/layout'

import HelloWorld from '@/components/HelloWorld'
// import Frame from '@/components/frame'
// import StudentList from '@/components/student/student-list'
// import StudentAdd from '@/components/student/student-add'
// import Upload from '@/components/student/student-add'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      component: () => import('@/views/pdf2doc/pdf2doc')
    },
    {
      path: '/2',
      component: () => import('@/views/pdf2doc/pdf2doc2')
    },
    {
      path: '/std',
      // component: Layout,
      component: () => import('@/views/student/frame'),
      redirect:  { name: 'StudentList' },
      // redirect: '/std/list',
      name: 'Example',
      meta: {
        title: 'example',
        icon: 'example'
      },
      children: [
        {
          path: 'add',
          component: () => import('@/views/student/student-add'),
          name: 'CreateStudent',
          meta: { title: 'createArticle', icon: 'edit' }
        },
        {
          path: 'list',
          component: () => import('@/views/student/student-list'),
          name: 'StudentList',
          meta: { title: 'articleList', icon: 'list' }
        }
      ]
    }
  ]
})
