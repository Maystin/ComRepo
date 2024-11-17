import Vue from 'vue'
import VueRouter from 'vue-router'
import Layout from '../views/Layout.vue'
import Cookies from 'js-cookie'

Vue.use(VueRouter)

const routes = [
    //   ====== 登录 ======
  {
    path: '/login',
    name: 'Login',
    component:  () => import('@/views/login/Login.vue'),
  },

   //   ====== 主页 ======

  {
    path: '/',
    name: 'home',
    component: Layout,
    redirect: '/home',
    children: [                               //子路由
      {
        path: 'home',
        name: 'Home',
        component: () => import('@/views/home/HomeView.vue'),
      },

      // ==== User ====
      {
        path: 'userList',
        name: 'UserList',
        component: () => import('@/views/user/User.vue'),
      },
      {
        path: 'addUser',
        name: 'AddUser',
        component: () => import('@/views/user/AddUser.vue'),
      },
      {
        path: 'editUser',
        name: 'EditUser',
        component: () => import('@/views/user/EditUser.vue'),
      },
      {
        path: 'userDetails',
        name: 'UserDetails',
        component: () => import('@/views/user/UserDetails.vue'),
      },
      {
        path: 'graduateList',
        name: 'GraduateList',
        component: () => import('@/views/user/GraduateStu.vue'),
      },
      {
        path: 'addGraduateStu',
        name: 'AddGraduateStu',
        component: () => import('@/views/user/AddGraduateStu.vue'),
      },
      {
        path: 'editGraduateStu',
        name: 'EditGraduateStu',
        component: () => import('@/views/user/EditGraduateStu.vue'),
      },
      // ==== Admin ====
      {
        path: 'adminList',
        name: 'AdminList',
        component: () => import('@/views/admin/List.vue'),
      },
      {
        path: 'addAdmin',
        name: 'AddAdmin',
        component: () => import('@/views/admin/Add.vue'),
      },
      {
        path: 'editAdmin',
        name: 'EditAdmin',
        component: () => import('@/views/admin/Edit.vue'),
      },
      // ==== Category ====
      { path: 'categoryList', name: 'CategoryList', component: () => import('@/views/category/List.vue') },
      { path: 'addCategory', name: 'AddCategory', component: () => import('@/views/category/Add.vue') },
      { path: 'editCategory', name: 'EditCategory', component: () => import('@/views/category/Edit.vue') },
    ]
  },
    //如若用户输入的路由均不在以上，则执行404
  {
    path: '*',
    component:() => import('@/views/404.vue')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

// 路由守卫
router.beforeEach((to, from, next)=>{
  if (to.path === '/login') next()
  const admin =Cookies.get("admin")
  if (!admin && to.path !== '/login') return next("/login")    //强制退回登陆页面
  // 访问 /home 的时候，并且cookie里存在数据，这个时候就直接放行
  next()
})


export default router
