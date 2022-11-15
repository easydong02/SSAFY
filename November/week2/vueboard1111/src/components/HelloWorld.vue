<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <div>
      <b-table-simple striped hover small caption-top responsive>
        <caption>
          인재군 군민들의 목소리
        </caption>
        <colgroup>
          <col style="width: 5%" />
          <col style="width: 45%" />
          <col style="width: 25%" />
          <col style="width: 25%" />
        </colgroup>
        <b-thead head-variant="dark">
          <b-tr>
            <b-th>글번호</b-th>
            <b-th>제목</b-th>
            <b-th>작성자</b-th>
            <b-th>작성일</b-th>
          </b-tr>
        </b-thead>
        <b-tbody>
          <article-item
            v-for="(article, index) in articles"
            :key="index"
            :article="article"
            :index="index"
          ></article-item>
        </b-tbody>
        <b-tfoot>
          <b-tr>
            <b-td colspan="4" variant="secondary" class="text-right">
              모든글수: <b>{{ articles.length }}</b>
            </b-td>
          </b-tr>
        </b-tfoot>
      </b-table-simple>
    </div>
  </div>
</template>

<script>
import http from "@/api/http.js";
import ArticleItem from "@/components/ArticleItem";
export default {
  name: "HelloWorld",
  components: {
    ArticleItem,
  },
  props: {
    msg: String,
  },
  data() {
    return {
      articles: [],
    };
  },
  created() {
    http.get(`/`).then(({ data }) => {
      this.articles = data;
    });
  },
};
</script>

<style scoped></style>
