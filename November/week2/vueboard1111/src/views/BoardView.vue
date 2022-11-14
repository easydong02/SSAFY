<template>
  <div>
    <b-container fluid class="bv-example-row">
      <b-row class="justify-content-md-center">
        <b-col><h2 class="text-center">철원군 게시판</h2></b-col>
      </b-row>
      <b-row class="justify-content-md-center">
        <b-col>
          <b-card>
            <b-card-header header-tag="nav">
              <b-nav card-header tabs>
                <!-- <b-nav-item>'s with child routes. Note the trailing slash on the first <b-nav-item> -->
                <b-nav-item to="/board/list" exact exact-active-class="active"
                  >글목록</b-nav-item
                >
                <b-nav-item to="/board/write" exact exact-active-class="active"
                  >글작성</b-nav-item
                >
              </b-nav>
            </b-card-header>
            <b-card-body>
              <router-view></router-view>
            </b-card-body>
          </b-card>
        </b-col>
      </b-row>
    </b-container>
  </div>
</template>

<script>
export default {};
</script>
<style scoped></style>
