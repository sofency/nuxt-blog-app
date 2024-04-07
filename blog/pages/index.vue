<template>
  <div class="index">
    <NavHeader />
    <BlogContent :pageVO="pageVO" @page-changed="updatePageVO" />
    <Fotter />
  </div>
</template>

<script>
import NavHeader from "../components/NavHeader.vue";
import BlogContent from "../components/BlogContent.vue";
import handleScroll from "../static/slip";
import Fotter from "../components/Fotter.vue";
export default {
  components: { NavHeader, BlogContent, Fotter },
  name: "IndexPage",
  async asyncData({ $axios }) {
    const responseData = await $axios({ url: "/api/blog/page" });
    console.log(responseData.data);
    return { pageVO: responseData.data.data };
  },
  mounted() {
    window.addEventListener("scroll", handleScroll);
  },
  methods: {
    updatePageVO(page) {
      console.log("current", page);
      var that = this;
      this.$axios({
        url: "/api/blog/page?current=" + page,
        method: "Get",
      }).then((res) => {
        console.log(res.data);
        that.pageVO = res.data.data;
      });
    },
  },
};
</script>
