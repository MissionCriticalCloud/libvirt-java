package org.libvirt.flags;

public final class DomainMigrateFlags {
    /**
     * live migration
     */
    static final int VIR_MIGRATE_LIVE = (1 << 0);
    /**
     * direct source -> dest host control channel
     */
    static final int VIR_MIGRATE_PEER2PEER = (1 << 1);
    /**
     * Note the less-common spelling that we're stuck with: VIR_MIGRATE_TUNNELLED should be VIR_MIGRATE_TUNNELED
     * <p>
     * tunnel migration data over libvirtd connection
     */
    static final int VIR_MIGRATE_TUNNELLED = (1 << 2);
    /**
     * persist the VM on the destination
     */
    static final int VIR_MIGRATE_PERSIST_DEST = (1 << 3);
    /**
     * undefine the VM on the source
     */
    static final int VIR_MIGRATE_UNDEFINE_SOURCE = (1 << 4);
    /**
     * pause on remote side
     */
    static final int VIR_MIGRATE_PAUSED = (1 << 5);
    /**
     * migration with non-shared storage with full disk copy
     */
    static final int VIR_MIGRATE_NON_SHARED_DISK = (1 << 6);
    /**
     * migration with non-shared storage with incremental copy
     * <p>
     * (same base image shared between source and destination)
     */
    static final int VIR_MIGRATE_NON_SHARED_INC = (1 << 7);
    /**
     * protect for changing domain configuration through the
     * whole migration process; this will be used automatically
     * when supported
     */
    static final int VIR_MIGRATE_CHANGE_PROTECTION = (1 << 8);
    /**
     * force migration even if it is considered unsafe
     */
    static final int VIR_MIGRATE_UNSAFE = (1 << 9);

    /**
     * Migrate a domain definition without starting the domain on the destination and without stopping it on the source host.
     * Offline migration requires VIR_MIGRATE_PERSIST_DEST to be set.
     * Offline migration may not copy disk storage or any other file based storage (such as UEFI variables).
     */
    static final int VIR_MIGRATE_OFFLINE = (1 << 10);

    /**
     * Compress migration data. The compression methods can be specified using VIR_MIGRATE_PARAM_COMPRESSION.
     * A hypervisor default method will be used if this parameter is omitted. Individual compression methods can be tuned
     * via their specific VIR_MIGRATE_PARAM_COMPRESSION_* parameters.
     */
    static final int VIR_MIGRATE_COMPRESSED = (1 << 11);

    /**
     * Cancel migration if a soft error (such as I/O error) happens during migration.
     */
    static final int VIR_MIGRATE_ABORT_ON_ERROR = (1 << 12);

    /**
     * Enable algorithms that ensure a live migration will eventually converge. This usually means the domain will
     * be slowed down to make sure it does not change its memory faster than a hypervisor can transfer the changed memory to the destination host.
     * VIR_MIGRATE_PARAM_AUTO_CONVERGE_* parameters can be used to tune the algorithm.
     */
    static final int VIR_MIGRATE_AUTO_CONVERGE = (1 << 13);

    /**
     * This flag can be used with RDMA migration (i.e., when VIR_MIGRATE_PARAM_URI starts with "rdma://") to tell the hypervisor to pin
     * all domain's memory at once before migration starts rather then letting it pin memory pages as needed. This means that all memory
     * pages belonging to the domain will be locked in host's memory and the host will not be allowed to swap them out.
     * For QEMU/KVM this requires hard_limit memory tuning element (in the domain XML) to be used and set to the maximum memory
     * configured for the domain plus any memory consumed by the QEMU process itself. Beware of setting the memory limit too
     * high (and thus allowing the domain to lock most of the host's memory). Doing so may be dangerous to both the domain and the host
     * itself since the host's kernel may run out of memory.
     */
    static final int VIR_MIGRATE_RDMA_PIN_ALL = (1 << 14);

    /**
     * Setting the VIR_MIGRATE_POSTCOPY flag tells libvirt to enable post-copy migration.
     * However, the migration will start normally and virDomainMigrateStartPostCopy needs to be called to switch it into the post-copy mode.
     * See virDomainMigrateStartPostCopy for more details.
     */
    static final int VIR_MIGRATE_POSTCOPY = (1 << 15);

    /**
     * Setting the VIR_MIGRATE_TLS flag will cause the migration to attempt to use the TLS environment configured by the hypervisor
     * in order to perform the migration. If incorrectly configured on either source or destination, the migration will fail.
     */
    static final int VIR_MIGRATE_TLS = (1 << 16);

    /**
     * Send memory pages to the destination host through several network connections.
     * See VIR_MIGRATE_PARAM_PARALLEL_* parameters for configuring the parallel migration.
     */
    static final int VIR_MIGRATE_PARALLEL = (1 << 17);

}
