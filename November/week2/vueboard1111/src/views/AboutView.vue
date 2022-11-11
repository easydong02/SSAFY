<template>
  <div class="about">
    <h1>철원군민 소원 리스트</h1>
    <div>
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
        <!-- #cell은 부트스트랩에서 쓸 수 있는 문법이다. column을 기준으로 작동한다. -->
        <template #cell(index)="data">
          {{ data.index + 1 }}
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
      <p class="mt-3">현재페이지: {{ currentPage }}/{{ totalPage() }}</p>
    </div>
  </div>
</template>
<script>
import http from "@/api/http.js";
export default {
  data() {
    return {
      perPage: 10,
      currentPage: 1,
      fields: [
        { key: "index", label: "번호" },
        { key: "userId", label: "사용자 아이디" },
        { key: "subject", label: "주제" },
        { key: "registerTime", label: "등록일" },
      ],
      articles: [],
    };
  },
  created() {
    http.get(`/`).then(({ data }) => {
      this.articles = data;
    });
  },
  methods: {
    showArticle(record, index) {
      console.log(record);
      console.log(index);
    },
    totalPage() {
      return Math.ceil(this.rows / this.perPage);
    },
  },
  computed: {
    rows() {
      return this.articles.length;
    },
  },
};
</script>
