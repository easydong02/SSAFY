<template>
  <div class="hello">
    <h1>인재군 게시글</h1>
    <div v-if="articles.length">
      <table id="book-list">
        <colgroup>
          <col style="width: 5%" />
          <col style="width: 45%" />
          <col style="width: 25%" />
          <col style="width: 25%" />
        </colgroup>
        <thead>
          <tr>
            <th>글번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>작성일</th>
            <th>삭제</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(article, index) in articles" :key="article.articleNo">
            <td v-text="index + 1"></td>
            <td
              v-text="article.subject"
              @click="showId(article.articleNo)"
            ></td>
            <td v-text="article.userId"></td>
            <td>{{ article.registerTime | showDate }}</td>
            <td @click="deleteboard(article.articleNo)">삭제</td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import http from "@/api/http.js";
export default {
  name: "BoardList",
  data() {
    return {
      articles: [],
    };
  },
  created() {
    http
      .get("/")
      .then(({ data }) => {
        console.log(data);
        this.articles = data;
      })
      .catch((error) => {
        console.log(error);
      });
  },
  methods: {
    showId(no) {
      this.$router.push(`/board/detail/${no}`);
    },
    deleteboard(no) {
      http
        .delete(`/${no}`)
        .then(({ data }) => {
          //console.log(data);
          this.articles = data;
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
  filters: {
    showDate(value) {
      return value.substr(0, 10);
    },
  },
};
</script>
<style scoped></style>
