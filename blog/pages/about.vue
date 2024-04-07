<template>
  <div class="about-container">
    <NavHeader />
    <CommonHeadImage :message="message" />
    <div class="informations">
      <div class="information-item">
        <div></div>
      </div>
    </div>
  </div>
</template>

<script>
import CommonHeadImage from "../components/CommonHeadImage.vue";
export default {
  components: { CommonHeadImage },
  data() {
    return {
      message: "Hello, I'm Sofency",
    };
  },
};
</script>

<style scoped lang="less">
.informations {
  padding-left: 100px;
  padding-right: 100px;
  margin-top: 20px;
}
</style>