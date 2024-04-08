<template>
  <div class="index">
    <NavHeader />
    <div class="index-container">
      <CommonHeadImage :message="message" />
      <Row type="flex" class="contents">
        <Col :span="24" :md="16" class="blog-list">
          <BlogContent :pageVO="pageVO" @page-changed="updatePageVO" />
        </Col>
        <Col :span="24" :md="8" class="sidebar">
          <IndexSideBar />
        </Col>
      </Row>
    </div>
    <Fotter />
  </div>
</template>

<script>
import NavHeader from "../components/NavHeader.vue";
import BlogContent from "../components/BlogContent.vue";
import handleScroll from "../static/slip";
import Fotter from "../components/Fotter.vue";
import IndexSideBarVue from "../components/IndexSideBar.vue";
import { Row, Col } from "ant-design-vue";

export default {
  components: { NavHeader, BlogContent, Fotter, IndexSideBarVue, Row, Col },
  name: "IndexPage",
  async asyncData({ $axios }) {
    const responseData = await $axios({ url: "/api/blog/page" });
    console.log(responseData.data);
    return { pageVO: responseData.data.data };
  },
  data() {
    return {
      message: "Hello World",
    };
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

<style scoped lang="less">
.contents {
  padding-left: 100px;
  padding-right: 100px;
  margin-top: 30px;
  padding-top: 10px;
}
</style>
