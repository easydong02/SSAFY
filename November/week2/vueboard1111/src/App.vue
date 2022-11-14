<template>
  <div id="app">
    <b-container fluid class="bv-example-row">
      <b-row class="vh-100 text-center" align-v="center">
        <b-col><header-nav></header-nav></b-col>
      </b-row>
      <b-row class="justify-content-md-center">
        <b-col><router-view /></b-col>
      </b-row>
    </b-container>
  </div>
</template>

<script>
import HeaderNav from "@/components/HeaderNav.vue";

export default {
  name: "App",
  components: { HeaderNav },
};
</script>

<style></style>
