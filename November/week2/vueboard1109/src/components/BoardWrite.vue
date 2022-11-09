<template>
  <div class="hello">
    <h1>인재군 글쓰기</h1>
    <div>
      <form
        action="#none"
        method="post"
        id="_frmForm"
        name="frmForm"
        @submit.prevent="addboard"
      >
        <table id="book-list">
          <colgroup>
            <col style="width: 25%" />
            <col style="width: 55%" />
          </colgroup>
          <tbody>
            <tr>
              <th>작성자</th>
              <input type="text" v-model="userId" id="userId" ref="userId" />
            </tr>
            <tr>
              <th>제목</th>
              <input type="text" v-model="subject" id="subject" ref="subject" />
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
                <input type="submit" value="글쓰기" />
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
  name: "BoardWrite",
  data() {
    return {
      userId: "",
      subject: "",
      content: "",
    };
  },
  created() {},
  methods: {
    addboard() {
      let err = true;
      let msg = "";
      !this.userId &&
        ((msg = "작성자 입력해 주세요"),
        (err = false),
        this.$refs.userId.focus());
      err &&
        !this.subject &&
        ((msg = "제목을 입력해 주세요"),
        (err = false),
        this.$refs.subject.focus());
      err &&
        !this.content &&
        ((msg = "내용을 입력해 주세요"),
        (err = false),
        this.$refs.content.focus());

      if (!err) alert(msg);
      else this.writeBoard();
    },
    writeBoard() {
      let myData = {
        userId: this.userId,
        subject: this.subject,
        content: this.content,
      };
      http
        .post(`/`, myData)
        .then(({ data }) => {
          if (data != null) alert("성공적으로 글을 작성하였습니다.");
          this.moveList();
        })
        .catch(() => {
          alert("글 작성 중 예기치 못한 오류가 발생하였습니다.");
          this.moveList();
        });
    },
    moveList() {
      this.$router.push("/board/list");
    },
  },
};
</script>
<style scoped></style>
