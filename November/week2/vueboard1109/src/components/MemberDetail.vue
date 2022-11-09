<template>
  <div class="hello">
    <h1>철원군 글</h1>
    <div>
      <form
        action="#none"
        method="post"
        id="_frmForm"
        name="frmForm"
        @submit.prevent="updatemember"
      >
        <table id="book-list">
          <colgroup>
            <col style="width: 25%" />
            <col style="width: 55%" />
          </colgroup>
          <tbody>
            <tr>
              <th>아이디</th>
              <td>
                <input
                  readonly
                  type="text"
                  v-model="member.userId"
                  id="userId"
                  ref="userId"
                />
              </td>
            </tr>
            <tr>
              <th>이름</th>
              <td>
                <input
                  type="text"
                  v-model="member.userName"
                  id="userName"
                  ref="userName"
                />
              </td>
            </tr>
            <tr>
              <th>비밀번호</th>
              <input
                type="text"
                v-model="member.userPwd"
                id="userPwd"
                ref="userPwd"
              />
            </tr>
            <tr>
              <th>가입일</th>
              <td>
                <input
                  readonly
                  type="text"
                  v-model="member.joinDate"
                  id="joinDate"
                  ref="joinDate"
                />
              </td>
            </tr>
            <tr>
              <th>이메일</th>
              <td>
                <input
                  type="text"
                  v-model="member.emailId"
                  id="emailId"
                  ref="emailId"
                />
                @
                <input
                  type="text"
                  v-model="member.emailDomain"
                  id="emailDomain"
                  ref="emailDomain"
                />
              </td>
            </tr>
            <tr>
              <td colspan="2">
                <input type="submit" value="회원수정" />
              </td>
            </tr>
          </tbody>
        </table>
      </form>
    </div>
  </div>
</template>

<script>
import http from "@/api/http2.js";
export default {
  name: "MemberDetail",
  data() {
    return {
      member: {},
    };
  },
  created() {
    let no = this.$route.params.userId;
    //this.$route.query.articleNo;
    http
      .get(`/${no}`)
      .then(({ data }) => {
        this.member = data;
      })
      .catch((error) => {
        console.log(error);
      });
  },
  methods: {
    updatemember() {
      http
        .put(`/`, this.member)
        .then(({ data }) => {
          if (data != null) alert("성공적으로 회원을 수정하였습니다.");
          this.moveMember(this.member.userId);
        })
        .catch(() => {
          alert("회원수정에 실패하였습니다.");
          this.moveList();
        });
    },
    moveList() {
      this.$router.push("/member/list");
    },
    moveMember(no) {
      this.$router.push(`/member/detail/${no}`);
    },
  },
};
</script>
<style scoped></style>
