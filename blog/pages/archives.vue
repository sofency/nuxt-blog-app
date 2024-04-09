<template>
  <div class="archive">
    <NavHeader />
    <CommonHeadImage :message="message" />
    <ArchiveDetail :archives="archives" />
  </div>
</template>

<script>
import ArchiveDetail from "../components/ArchiveDetail.vue";
export default {
  components: { ArchiveDetail },
  data() {
    return {
      message: "归档",
      archives: [],
    };
  },
  async asyncData({ $axios }) {
    const responseData = await $axios({ url: "/api/blog/archive/" });
    return { archives: responseData.data.data };
  },
};
</script>

<style scoped lang="less">
.index {
  .container {
    width: 80%;
    border: 1px solid red;
    border-radius: 10px;
    margin-left: auto;
    margin-right: auto;
    text-align: left;
  }
}
</style>