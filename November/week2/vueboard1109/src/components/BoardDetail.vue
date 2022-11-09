<template>
  <div class="hello">
    <h1>인재군 글</h1>
    <div>
      <form
        action="#none"
        method="post"
        id="_frmForm"
        name="frmForm"
        @submit.prevent="updateboard"
      >
        <table id="book-list">
          <colgroup>
            <col style="width: 25%" />
            <col style="width: 55%" />
          </colgroup>
          <tbody>
            <tr>
              <th>글번호</th>
              <td>
                <input
                  readonly
                  type="text"
                  v-model="articleNo"
                  id="articleNo"
                  ref="articleNo"
                />
              </td>
            </tr>
            <tr>
              <th>작성자</th>
              <td>
                <input
                  readonly
                  type="text"
                  v-model="userId"
                  id="userId"
                  ref="userId"
                />
              </td>
            </tr>
            <tr>
              <th>제목</th>
              <input type="text" v-model="subject" id="subject" ref="subject" />
            </tr>
            <tr>
              <th>작성일</th>
              <td>
                <input
                  readonly
                  type="text"
                  v-model="registerTime"
                  id="registerTime"
                  ref="registerTime"
                />
              </td>
            </tr>
            <tr>
              <th>조회수</th>
              <td>
                <input readonly type="text" v-model="hit" id="hit" ref="hit" />
              </td>
            </tr>
            <tr>
              <th>내용</th>
              <textarea
                v-model="content"
                id="content"
                ref="content"
                rows="5"
              ></textarea>
            </tr>
            <tr>
              <td colspan="2">
                <input type="submit" value="글수정" />
              </td>
            </tr>
          </tbody>
        </table>
      </form>
    </div>
  </div>
</template>

<script>
import http from "@/api/http.js";
export default {
  name: "BoardDetail",
  data() {
    return {
      articleNo: "",
      userId: "",
      subject: "",
      content: "",
      registerTime: "",
      hit: 0,
    };
  },
  created() {
    let no = this.$route.params.articleNo;
    //this.$route.query.articleNo;
    http
      .get(`/${no}`)
      .then(({ data }) => {
        //console.log(data);
        this.articleNo = data.articleNo;
        this.userId = data.userId;
        this.subject = data.subject;
        this.content = data.content;
        this.registerTime = data.registerTime;
        this.hit = data.hit;
      })
      .catch((error) => {
        console.log(error);
      });
  },
  methods: {
    updateboard() {
      let myData = {
        articleNo: this.articleNo,
        userId: this.userId,
        subject: this.subject,
        content: this.content,
      };
      http
        .put(`/`, myData)
        .then(({ data }) => {
          if (data != null) alert("성공적으로 글을 수정하였습니다.");
          this.moveBoard(this.articleNo);
        })
        .catch(() => {
          alert("글수정에 실패하였습니다.");
          this.moveList();
        });
    },
    moveList() {
      this.$router.push("/board/list");
    },
    moveBoard(no) {
      this.$router.push(`/board/detail/${no}`);
    },
  },
};
</script>
<style scoped></style>
