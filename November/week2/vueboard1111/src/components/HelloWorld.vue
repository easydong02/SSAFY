<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <div>
      <b-table-simple hover small caption-top responsive>
        <caption>
          인재군 군민들의 목소리:
        </caption>
        <colgroup>
          <col />
          <col />
        </colgroup>
        <colgroup>
          <col />
          <col />
          <col />
        </colgroup>
        <colgroup>
          <col />
          <col />
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
          <!-- <b-tr v-for="(article, index) in articles" :key="article.articleNo">
            <b-td v-text="index + 1"></b-td>
            <b-td v-text="article.subject"></b-td>
            <b-td v-text="article.userId"></b-td>
            <b-td>{{ article.registerTime }}</b-td>
          </b-tr> -->
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
              Total Rows: <b>{{ articles.length }}</b>
            </b-td>
          </b-tr>
        </b-tfoot>
      </b-table-simple>
    </div>
  </div>
</template>

<script>
import http from "@/api/http.js";
import ArticleItem from "@/components/ArticleItem.vue";

export default {
  name: "HelloWorld",
  props: {
    msg: String,
  },
  components: {
    ArticleItem,
  },
  data() {
    return {
      articles: [],
    };
  },

  created() {
    http.get(`/`).then(({ data }) => (this.articles = data));
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
