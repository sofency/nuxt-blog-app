<template>
  <div class="daily-container">
    <NavHeader />
    <daily-content />
  </div>
</template>

<script>
import DailyContent from "../components/DailyContent.vue";
export default {
  components: { DailyContent },
};
</script>