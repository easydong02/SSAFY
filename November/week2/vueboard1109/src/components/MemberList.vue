<template>
  <div class="hello">
    <h1>철원군 게시글</h1>
    <div v-if="members.length">
      <table id="user-list">
        <colgroup>
          <col style="width: 5%" />
          <col style="width: 45%" />
          <col style="width: 25%" />
          <col style="width: 25%" />
        </colgroup>
        <thead>
          <tr>
            <th>번호</th>
            <th>아이디</th>
            <th>이름</th>
            <th>가입일</th>
            <th>삭제</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(member, index) in members" :key="member.userId">
            <td v-text="index"></td>
            <td v-text="member.userId" @click="showId(member.userId)"></td>
            <td v-text="member.userName"></td>
            <td>{{ member.joinDate | showDate }}</td>
            <td @click="deletemember(member.userId)">삭제</td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import http from "@/api/http2.js";
export default {
  name: "MemberList",
  data() {
    return {
      members: [],
    };
  },
  created() {
    http
      .get("/")
      .then(({ data }) => {
        console.log(data);
        this.members = data;
      })
      .catch((error) => {
        console.log(error);
      });
  },
  methods: {
    showId(no) {
      this.$router.push(`/member/detail/${no}`);
    },
    deletemember(no) {
      http
        .delete(`/${no}`)
        .then(({ data }) => {
          //console.log(data);
          this.members = data;
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
