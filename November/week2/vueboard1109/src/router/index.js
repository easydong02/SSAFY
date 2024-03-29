import Vue from "vue";
import VueRouter from "vue-router";

import BoardView from "@/views/BoardView.vue";
import BoardList from "@/components/BoardList.vue";
import BoardDetail from "@/components/BoardDetail.vue";
import BoardWrite from "@/components/BoardWrite.vue";

import MemberView from "@/views/MemberView.vue";
import MemberList from "@/components/MemberList.vue";
import MemberDetail from "@/components/MemberDetail.vue";
Vue.use(VueRouter);

const routes = [
  {
    path: "/member",
    name: "member",
    component: MemberView,
    redirect: "/member/list",
    children: [
      {
        path: "list",
        name: "list",
        component: MemberList,
      },
      {
        path: "detail/:userId",
        name: "detail",
        component: MemberDetail,
      },
    ],
  },
  {
    path: "/board",
    name: "board",
    component: BoardView,
    redirect: "/board/list",
    children: [
      {
        path: "list",
        name: "list",
        component: BoardList,
      },
      {
        path: "detail/:articleNo",
        name: "detail",
        component: BoardDetail,
      },
      {
        path: "write",
        name: "write",
        component: BoardWrite,
      },
    ],
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
