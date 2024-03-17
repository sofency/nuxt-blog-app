<template>
  <div class="daily-content">
    <common-head-image :message="message" />
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