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
        <template #cell(index)="article">
          {{ article.index + 1 }}
        </template>
        <template #cell(registerTime)="article">
          {{ article.item.registerTime | showDate }}
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
        { key: "index", label: "번호", thClass: "w10" },
        { key: "userId", label: "사용자 아이디", thClass: "w20" },
        { key: "subject", label: "주제", thClass: "w40" },
        { key: "registerTime", label: "등록일", thClass: "w30" },
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
      //this.$emit("row-clicked", record);
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
  filters: {
    showDate(value) {
      return value.substring(0, 10);
    },
  },
};
</script>
