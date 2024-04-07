<template>
  <div class="resource-content">
    <common-head-image :message="message" />
    <div class="resource-list">
      <div class="resource-item">
        <div class="resource-header">高质量学习网站</div>
      </div>
      <div class="resource-item">
        <div class="resource-header">JAVA</div>
      </div>
      <div class="resource-item">
        <div class="resource-header">高质量学习网站</div>
      </div>
    </div>
  </div>
</template>

<script>
import CommonHeadImage from "./CommonHeadImage.vue";
export default {
  components: { CommonHeadImage },
  data() {
    return {
      message: "Daily",
    };
  },
};
</script>

<style scoped lang="less">
.resource-content {
  .resource-list {
    padding-left: 100px;
    padding-right: 100px;
    margin-top: 20px;
    font-size: 20px;
  }
}
</style>