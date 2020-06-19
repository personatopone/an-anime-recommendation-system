import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

  const routes = [
 
  {
    path: '/',
    name: 'Homepage',
    component: () => import( '../views//homepage/Homepage.vue')
  }
]

const router = new VueRouter({
  routes
})

export default router
