<template>
  <b-container class="bv-example-row mt-3">
    <b-row>
      <b-col>
        <b-alert show><h3>글목록</h3></b-alert>
      </b-col>
    </b-row>
    <b-row class="mb-1">
      <b-col class="text-right">
        <b-button variant="outline-primary" @click="moveWrite()"
          >글쓰기</b-button
        >
      </b-col>
    </b-row>
    <b-table
      id="tbarticle"
      striped
      hover
      :items="articles"
      :fields="fields"
      :per-page="perPage"
      :current-page="currentPage"
      @row-clicked="showArticle"
    >
      <template #cell(index)="article">
        {{ article.index + 1 }}
      </template>
      <template #cell(subject)="article">
        <router-link
          :to="{
            name: 'BoardView',
            params: { articleno: article.item.articleno },
          }"
          >{{ article.item.subject }}</router-link
        >
      </template>

      <template #cell(registerTime)="article">
        {{ article.item.regtime | showDate }}
      </template>
    </b-table>
    <b-pagination
      pills
      size="sm"
      align="center"
      v-model="currentPage"
      :total-rows="rows"
      :per-page="perPage"
      aria-controls="tbarticle"
    ></b-pagination>
    <p class="mt-3">
      현재페이지: {{ currentPage }}/{{ totalPage() }}: 전체페이지
    </p>
  </b-container>
</template>

<script>
import { listArticle } from "@/api/board.js";

export default {
  name: "BoardList",
  components: {},
  data() {
    return {
      articles: [],
      perPage: 20,
      currentPage: 1,
      fields: [
        { key: "index", label: "번호", thClass: "w10" },
        { key: "userid", label: "사용자 아이디", thClass: "w20" },
        { key: "subject", label: "제목", thClass: "w40" },
        { key: "regtime", label: "등록일", thClass: "w30" },
      ],
    };
  },
  created() {
    let param = {
      pg: 1,
      spp: 1000,
      key: null,
      word: null,
    };
    listArticle(
      param,
      (response) => {
        this.articles = response.data;
      },
      (error) => {
        console.log(error);
      }
    );
  },
  methods: {
    moveWrite() {
      this.$router.push({ name: "BoardWrite" });
    },
    totalPage() {
      return Math.ceil(this.rows / this.perPage);
    },
  },
  computed: {
    rows() {
      console.log("총 게시글 수: " + this.articles.length);
      return this.articles.length;
    },
  },
  filters: {
    showDate(value) {
      return value.substring(0, 10);
    },
  },
};
</script>

<style scope>
.tdClass {
  width: 50px;
  text-align: center;
}
.tdSubject {
  width: 300px;
  text-align: left;
}
</style>
