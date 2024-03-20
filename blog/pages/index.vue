<template>
  <div class="index">
    <NavHeader />
    <BlogContent :articles="articles" />
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
    const responseData = await $axios({ url: "/api/blog" });
    console.log(responseData.data);
    return { articles: responseData.data.data };
  },
  // async asyncData({ $content }) {
  //   const articles = await $content("articles").fetch();
  //   return { articles };
  // },
  mounted() {
    window.addEventListener("scroll", handleScroll);
  },
};
</script>
