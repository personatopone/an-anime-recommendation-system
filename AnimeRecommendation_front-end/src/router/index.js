import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [


  {
    path: '/homepage',
    name: 'Homepage',
    component: () => import('../views//homepage/Homepage.vue'),
    children: [{
        path: "",
        name: "content",
        component: () => import('../views/homepage/Content.vue')
      },
      {
        path:"ranking",
        name:"Ranking",
        component: () => import('../views/ranking/RankingContent.vue')
      },
      {
        path:"search",
        name:"search",
        component:() => import("../views/Search/Search.vue")

      }
    ]
  },
  {
    path:"/",redirect: "/homepage"
  },
  {
    path: "/detail",
    name: "Detail",
    component: () => import("../views/animeDetail/detail.vue")
  }
]

const router = new VueRouter({
  routes
})

export default router