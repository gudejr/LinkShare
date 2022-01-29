import Vue from 'vue'
import VueRouter from 'vue-router'
import store from '../store/index.js'
import Newsfeed from '../views/Newsfeed.vue'
import Linkboxdetail from '../views/Linkboxdetail.vue'
import Toplinkbox from '../views/Toplinkbox'


Vue.use(VueRouter)

const routes = [
  {
    path: '/welcome',
    name: 'welcome',
    component: () => import('../views/welcome.vue')
  },
  {
    path: '/home',
    name: 'home',
    component: () => import('../views/home.vue')
  },
  {
    path: '/',
    redirect: () => {
      if (store.state.loggedIn) {
        return '/home';
      } else {
        return '/welcome';
      }
    }
  },
  {
    path: '/about',
    name: 'about',
    component: () => import('../views/About.vue')
  },
  {
    path: '/signup',
    name: 'signup',
    component: () => import('../views/signup.vue')
  },
  {
    path: '/login',
    name: 'login',
    component: () => import('../views/login.vue')
  },
  {
    path: '/profile',
    name: 'profile',
    component: () => import('../views/profile.vue')
  },
  {
    path: '/newsfeed',
    name: 'Newsfeed',
    component: Newsfeed
  },
  {
    path: '/linkboxdetail',
    name: 'Linkboxdetail',
    component: Linkboxdetail
  },
  {
    path: '/toplinkbox',
    name: 'Toplinkbox',
    component: Toplinkbox
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
