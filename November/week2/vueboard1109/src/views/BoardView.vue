<template>
  <div class="container">
    <h2 class="text-center">인재군 게시판</h2>
    <nav>
      <router-link to="/board/list">글 목록 | </router-link>
      <router-link to="/board/write">글 작성</router-link>
    </nav>
    <router-view></router-view>
  </div>
</template>
<script>
export default {};
</script>
<style scoped></style>
