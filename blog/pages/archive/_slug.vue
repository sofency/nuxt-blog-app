<template>
  <div class="archiver-container">
    <NavHeader />
    <div class="archiver-view">
      <CommonHeadImage :message="message" />

      <div class="archives">
        <div class="archive-list">
          <div class="article-sort-title">归档 - {{ message }}</div>
          <div class="article-sort" v-for="blog in blogs" :key="blog">
            <div class="article-sort-item">
              <div class="article-sort-item-time">
                <a-icon type="calendar" />
                {{ blog.createTime.substring(0, 10) }}
              </div>
            </div>
            <NuxtLink class="article-id" :to="`/blog/${blog.id}`">{{
              blog.title
            }}</NuxtLink>
          </div>
        </div>
        <div class="archiver-bottom">
          <a-pagination
            :current="current"
            :pageSize="pageSize"
            :total="total"
            :hideOnSinglePage="false"
            :showPrevNextButtons="true"
            @change="handlePageChange"
          >
            <template #itemRender="{ page, type }">
              <a v-if="type === 'prev'">Previous</a>
              <a v-else-if="type === 'next'">Next</a>
              <span v-else>{{ page }}</span>
            </template>
          </a-pagination>
        </div>
      </div>
    </div>
    <Fotter />
  </div>
</template>


<script>
import NavHeader from "../../components/NavHeader.vue";
import Fotter from "../../components/Fotter.vue";
import { Row, Col } from "ant-design-vue";
export default {
  async asyncData({ $axios, params, query }) {
    console.log(query.name);
    const responseData = await $axios({
      url: `/api/blog/page/archive/${params.slug}`,
    });
    var result = responseData.data.data;
    return {
      current: result.current,
      pageSize: result.page,
      total: result.total,
      blogs: result.results,
      archiveId: params.slug,
    };
  },
  data() {
    return {
      message: this.$route.query.name,
    };
  },
  methods: {
    handlePageChange(page) {
      this.current = page;
      var that = this;
      this.$axios({
        url: `/api/blog/page/archive/${this.archiveId}?current=` + this.current,
      }).then((res) => {
        var result = res.data.data;
        that.pageSize = result.page;
        that.total = result.total;
        that.blogs = result.results;
      });
    },
  },
  components: { NavHeader, Row, Col, Fotter },
};
</script>

<style scoped lang="less">
.archives {
  width: 68%;
  margin-left: auto;
  margin-right: auto;
}
.archive-list {
  align-self: flex-start;
  -ms-flex-item-align: start;
  padding: 50px 0px;
}
.article-sort-title {
  position: relative;
  margin-left: 10px;
  padding-bottom: 20px;
  padding-left: 20px;
  font-size: 1.72em;
}
.article-sort-title:before {
  position: absolute;
  top: calc(((100% - 36px) / 2));
  left: -9px;
  z-index: 1;
  width: 20px;
  height: 20px;
  border: 5px solid #225a50;
  border-radius: 10px;
  background: var(--card-bg);
  content: "";
  line-height: 10px;
  -webkit-transition: all 0.2s ease-in-out;
  -moz-transition: all 0.2s ease-in-out;
  -o-transition: all 0.2s ease-in-out;
  -ms-transition: all 0.2s ease-in-out;
  transition: all 0.2s ease-in-out;
}
.article-sort-title:after {
  position: absolute;
  bottom: 0;
  left: 0;
  z-index: 0;
  width: 2px;
  height: 1.5em;
  background: #3ea492;
  content: "";
}

.article-sort {
  margin-left: 10px;
  padding-left: 20px;
  border-left: 2px solid #3ea492;
  padding-bottom: 15px;
  font-size: 18px;
}
.article-sort-item {
  position: relative;
  display: flex;
  align-items: center;
  padding: 5px 0 5px 0px;
  transition: all 0.2s ease-in-out;
}

.article-sort-item:before {
  position: absolute;
  left: calc(-20px - 7px);
  width: 12px;
  height: 12px;
  border: 3px solid #225a50;
  border-radius: 6px;
  background: var(--card-bg);
  content: "";
  -webkit-transition: all 0.2s ease-in-out;
  -moz-transition: all 0.2s ease-in-out;
  -o-transition: all 0.2s ease-in-out;
  -ms-transition: all 0.2s ease-in-out;
  transition: all 0.2s ease-in-out;
}

.article-id:hover {
  color: #3ea492;
}
</style>

