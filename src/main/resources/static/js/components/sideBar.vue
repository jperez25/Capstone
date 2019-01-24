
<template>
    <!-- Sidebar -->
        <div id="sidebar" class="sidebar-offcanvas">
          <div class="col-sm-12">
            <h3>Patients</h3>
              <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="text" id="patient_search" onkeydown="get_Patients()" placeholder="Last Name" aria-label="Search">
              </form>
          </div>
      </div>
    <!-- /#sidebar-wrapper -->    
</template>

<script>
    export default {
        props: ['last_name'],

        data() {
            return {
                patients: []
            }              
        },

        mounted() {
            
        },

        methods: {
            get_Patients(){
                axios.get('/get_pat', {params: {}})
                .then((response) => {
                   //console.log(response.data);
                    for (var key in response.data) {
                            //alert(response.data[key]);
                            console.log(response.data[key]);
                    } 
                });
            }

        }
    }
</script>

