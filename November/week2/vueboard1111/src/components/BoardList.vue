<template>
  <div>
    <b-container fluid class="bv-example-row">
      <b-row>
        <b-col></b-col>
        <b-col cols="10">
          <h1>철원군</h1>
          <div>
            <b-table-simple striped hover small caption-top responsive>
              <caption>
                철원군 군민들의 목소리
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
        </b-col>
        <b-col></b-col>
      </b-row>
    </b-container>
  </div>
</template>

<script>
import http from "@/api/http.js";
import ArticleItem from "@/components/ArticleItem";
export default {
  name: "BoardList",
  components: {
    ArticleItem,
  },
  data() {
    return {
      articles: [],
    };
  },
  created() {
    this.boardlist();
  },
  methods: {
    showId(no) {
      this.$router.push(`/board/detail/${no}`);
    },
    deleteId(no) {
      http
        .delete(`/${no}`)
        .then(({ data }) => {
          if (data != null) alert("성공적으로 삭제 했습니다.");
          this.boardlist();
        })
        .catch((error) => {
          console.log(error);
          alert("삭제에 실패했습니다.");
          this.boardlist();
        });
    },
    moveList() {
      this.$router.push("/board/list");
    },
    boardlist() {
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
  },
  filters: {
    showDate(value) {
      return value.substring(0, 10);
    },
  },
};
</script>
<style scoped></style>
