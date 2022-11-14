<template>
  <div>
    <b-card title="게시판" no-body align="center">
      <b-card-header header-tag="nav">
        <b-nav card-header tabs>
          <b-nav-item to="/board" exact exact-active-class="active"
            ><img src="@/assets/ceilwon.png"
          /></b-nav-item>
          <b-nav-item to="/user" exact exact-active-class="active"
            ><img src="@/assets/innjae.png"
          /></b-nav-item>
        </b-nav>
      </b-card-header>
    </b-card>
  </div>
</template>

<script>
export default {
  name: "HeaderNav",
};
</script>
