<template>
  <b-tr>
    <b-td v-text="index + 1"></b-td>
    <b-td v-text="article.subject"></b-td>
    <b-td v-text="article.userId"></b-td>
    <b-td>{{ article.registerTime }}</b-td>
  </b-tr>
</template>

<script>
export default {
  name: "AritlceItem",
  props: {
    article: Object,
    index: Number,
  },
};
</script>

<style></style>
